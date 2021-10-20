package com.zhangxx.java8.svn;

import com.zhangxx.java8.ZipUtil;
import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Svn工具
 */
public class SvnTest {

  static SVNURL svnUrl;

  private final static Properties PROPERTIES = configInit();


  /**
   * SVN 地址
   */
  private final static String URL = Objects.requireNonNull(PROPERTIES).getProperty("URL");
  /**
   * svn root 地址
   */
  private final static String CODE_URL = Objects.requireNonNull(PROPERTIES).getProperty("CODE_URL");
  /**
   * 账号名
   */
  private final static String USERNAME = Objects.requireNonNull(PROPERTIES).getProperty("USERNAME");
  /**
   * 密码
   */
  private final static String PASSWORD = Objects.requireNonNull(PROPERTIES).getProperty("PASSWORD");
  /**
   * 导出地址
   */
  private final static String EXPORT_PATH = Objects.requireNonNull(PROPERTIES).getProperty("EXPORT_PATH");
  private final static String EXPORT_ZIP_NAME = Objects.requireNonNull(PROPERTIES).getProperty("EXPORT_ZIP_NAME");
  /**
   * 检索范围 条数
   */
  private final static int LIMIT = 15;


  public static void main(String[] args) throws SVNException {
    System.out.println("启动SVN客户端Start");
    DAVRepositoryFactory.setup();
    SVNRepositoryFactoryImpl.setup();
    FSRepositoryFactory.setup();
    try {
      svnUrl = SVNURL.parseURIEncoded(URL);
    } catch (SVNException e) {
      e.printStackTrace();
    }
    ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
    SVNClientManager svnClientManager = SVNClientManager.newInstance(
            (DefaultSVNOptions) options, USERNAME, PASSWORD);
    SVNUpdateClient updateClient = svnClientManager.getUpdateClient();

    SVNLogClient logClient = svnClientManager.getLogClient();

    //获取日志
    AtomicReference<List<SVNLogEntry>> logList = new AtomicReference<>(getSvnLogEntries(logClient, LIMIT));
    AtomicReference<List<SVNLogEntry>> exportList = new AtomicReference<>(new ArrayList<>());
    System.out.println("启动SVN客户端End");
    //-----启动图形化界面
    System.out.println("生成图形化界面 start");
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame jframe = new JFrame("SVN ");
    JTextField stuteText = new JTextField(20);
    stuteText.setEditable(false);
    JScrollPane panel = new JScrollPane();
    // 添加面板

    panel.setLayout(null);

    // 创建 JLabel
    JLabel limitLabel = new JLabel("limit:");
    /* 这个方法定义了组件的位置。
     * setBounds(x, y, width, height)
     * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
     */
    limitLabel.setBounds(10, 20, 80, 25);
    panel.add(limitLabel);

    /*
     * 创建文本域用于用户输入
     */
    JTextField limitText = new JTextField(20);
    limitText.setBounds(100, 20, 165, 25);
    limitText.setText(String.valueOf(LIMIT));
    panel.add(limitText);

    // 输入author的文本域
    JLabel authorLabel = new JLabel("author:");
    authorLabel.setBounds(10, 50, 80, 25);
    panel.add(authorLabel);

    /*
     *这个类似用于输入的文本域
     * 但是输入的信息会以点号代替，用于包含密码的安全性
     */
    JTextField authorText = new JTextField(20);
    authorText.setText(USERNAME);
    authorText.setBounds(100, 50, 165, 25);
    panel.add(authorText);
    //修改列表显示
    JTextArea changedPathLabel = new JTextArea();
    changedPathLabel.setEditable(false);

    changedPathLabel.setBounds(550, 80, 1000, 500);
    //展示列表
    JTable table = new JTable();
    table.setRowHeight(15);


    String[] columns = {"Author", "Message", "Date"};
    //creat table mode
    DefaultTableModel model = new MyDefaultTableModel(columns, 0);
    table.setBounds(10, 80, 500, 500);
    table.setModel(model);
    table.getSelectionModel().addListSelectionListener(e -> {
      int[] selectedRows = table.getSelectedRows();

      List<SVNLogEntry> svnLogEntries = logList.get();
      Map<String, SVNLogEntryPath> changedPaths = new HashMap<>();
      exportList.get().clear();
      for (int selectedRow : selectedRows) {
        exportList.get().add(svnLogEntries.get(selectedRow));
        changedPaths.putAll(svnLogEntries.get(selectedRow).getChangedPaths());
      }

      StringBuilder listText = new StringBuilder();
      changedPaths.forEach((s, svnLogEntryPath) -> listText.append(s).append("\n"));
//            listText.append("</html>");
      changedPathLabel.setText(listText.toString());


    });

    panel.add(table);
    panel.add(changedPathLabel);


    //查询按钮
    JButton seachExport = new JButton("查询");

    seachExport.addActionListener(event -> {
      stuteText.setText("查询中");

      try {
        List<Function<SVNLogEntry, Boolean>> filterList = new LinkedList<>();
        String authorLabelText = authorText.getText();
        String limitLabelText = limitText.getText();
        if (authorLabelText.trim().length() > 0) {
          filterList.add(s -> s.getAuthor().startsWith(authorLabelText));
        }
        int limit = LIMIT;
        if (limitLabelText.trim().length() > 0) {
          limit = Integer.parseInt(limitLabelText);
        }
        List<SVNLogEntry> collect = getSvnLogEntries(logClient, limit);
        //筛选日志
        for (Function<SVNLogEntry, Boolean> filterFunction : filterList) {
          collect = filterSvnLogEntries(collect, filterFunction);
        }
        logList.set(collect);
        stuteText.setText("查询完成");
        stuteText.setText("刷新列表中");


        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        for (SVNLogEntry info : logList.get()) {
          String[] s = new String[3];

          s[0] = info.getAuthor();
          s[1] = info.getMessage();

          SimpleDateFormat smd = new SimpleDateFormat("yyyy-MM-dd");
          s[2] = smd.format(info.getDate());
          model.addRow(s);
        }
        stuteText.setText("刷新列表完成");
      } catch (SVNException e) {
        e.printStackTrace();
      }
    });


    //导出按钮
    JButton exportExport = new JButton("导出");
    exportExport.addActionListener(event -> {
      if (exportList.get().size() == 0) {
        stuteText.setText("未选择数据");
        return;
      }
      stuteText.setText("导出中");
      try {
        List<SVNLogEntry> svnLogEntries = getSvnLogEntries(logClient, 1);
        doExport(exportList.get(), updateClient, SVNRevision.create(svnLogEntries.get(0).getRevision()));
      } catch (SVNException e) {
        e.printStackTrace();

      }
      stuteText.setText("导出完成");
    });


    JMenuBar menuBar = new JMenuBar();

    menuBar.add(seachExport);
    menuBar.add(exportExport);
    menuBar.add(stuteText);
    jframe.setJMenuBar(menuBar);
    jframe.setPreferredSize(new Dimension(800, 600));
    jframe.setContentPane(panel);

    jframe.setVisible(true);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.pack();
  }


  private static List<SVNLogEntry> filterSvnLogEntries(List<SVNLogEntry> logList, Function<SVNLogEntry, Boolean> filter) {
    return logList.parallelStream().filter(filter::apply).collect(Collectors.toList());
  }

  private static List<SVNLogEntry> getSvnLogEntries(SVNLogClient logClient, int limit) throws SVNException {
    List<SVNLogEntry> logList = new LinkedList<>();

    logClient.doLog(svnUrl, null, SVNRevision.HEAD, null, null, true, true, limit, new ISVNLogEntryHandler() {
      /**
       * Handles a log entry passed.
       *
       * @param logEntry an {@link SVNLogEntry} object
       *                 that represents per revision information
       *                 (committed paths, log message, etc.)
       */
      @Override
      public void handleLogEntry(SVNLogEntry logEntry) {

        logList.add(logEntry);
      }
    });
    return logList;
  }

  /**
   * 导出并生成zip
   *
   * @param logList      日志文件
   * @param updateClient svn客户端
   */
  private static void doExport(List<SVNLogEntry> logList, SVNUpdateClient updateClient, SVNRevision svnRevision) {
    logList.forEach(svnLogEntry -> {
      try {
        doExport(updateClient, svnLogEntry, svnRevision);
      } catch (SVNException e) {
        e.printStackTrace();
      }
    });

    File zip = new File(EXPORT_PATH, EXPORT_ZIP_NAME + ".zip");
    if (zip.exists()) {
      boolean delete = zip.delete();
    }
    ZipUtil.compress(EXPORT_PATH + "/" + EXPORT_ZIP_NAME);
    File r = new File(EXPORT_PATH + "/" + EXPORT_ZIP_NAME);
    deleteFile(r);

  }

  private static void doExport(SVNUpdateClient updateClient, SVNLogEntry svnLogEntry, SVNRevision svnRevision) throws SVNException {


    Map<String, SVNLogEntryPath> changedPaths = svnLogEntry.getChangedPaths();
    Collection<SVNLogEntryPath> values = changedPaths.values();
    for (SVNLogEntryPath value : values) {

      String path = value.getPath();
      System.out.println("path" + path);
      if (svnRevision == null) {
        svnRevision = SVNRevision.create(svnLogEntry.getRevision());
      }

      //                    //添加或更新
      File file = new File(EXPORT_PATH, path);
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      updateClient.doExport(SVNURL.parseURIEncoded(CODE_URL + path), file, SVNRevision.HEAD, svnRevision, "native", true, SVNDepth.INFINITY);

    }
  }

  private static void deleteFile(File file) {
    //判断文件不为null或文件目录存在
    if (file == null || !file.exists()) {
      System.out.println("文件删除失败,请检查文件路径是否正确");
      return;
    }
    //取得这个目录下的所有子文件对象
    File[] files = file.listFiles();
    //遍历该目录下的文件对象
    for (File f : files) {
      //打印文件名
      String name = file.getName();
//            System.out.println(name);
      //判断子目录是否存在子目录,如果是文件则删除
      if (f.isDirectory()) {
        deleteFile(f);
      } else {
        f.delete();
      }
    }
    //删除空文件夹  for循环已经把上一层节点的目录清空。
    file.delete();
  }


  private static Properties configInit() {
    //读取文件
    File file = new File("./src/main/resources/config.properties");
    if (!file.exists()) {
      return null;
    }

    FileInputStream fis = null;
    Properties config = new Properties();
    try {
      fis = new FileInputStream(file);
      config.load(fis);
    } catch (Exception e) {
      e.printStackTrace();
    }


    return config;


  }
}
