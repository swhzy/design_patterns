    package com.swh.design.delegate.simple;

    public class Boss {

        public static void main(String[] args) {
            Leader leader = new Leader();
            leader.executer("注册");
            leader.executer("登录");

        }

    }
