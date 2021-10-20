package com.zhangxx.java8.leetcode;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public ListNode() {
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return val + (next == null ? "" : "->" + next);
  }
}
