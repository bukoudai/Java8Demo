package com.zhangxx.java8.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LinkNode {

  int val;
  int state;
  List<LinkNode> next;

  LinkNode(int val, int state) {
    this.val = val;
    this.state = state;
  }

  public List<LinkNode> add(int val) {
    List<LinkNode> next = new ArrayList<>();
    //待买入
    if (state == 0) {
      //下一步 待买入
      LinkNode a = new LinkNode(val, 0);
      //下一步  持有
      LinkNode b = new LinkNode(val, 1);
      next.add(a);
      next.add(b);
      //持有
    } else if (state == 1) {
      //下一步 持有
      LinkNode a = new LinkNode(val, 1);
      //下一步  冻结 卖出
      LinkNode b = new LinkNode(val, 2);
      next.add(a);
      next.add(b);
    } else if (state == 2) {
      //下一步 持有
      LinkNode a = new LinkNode(val, 0);
      next.add(a);
    }


    this.next = next;
    return next;
  }

}
