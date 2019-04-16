package pers.qly.deep.in.java.stage1.lesson2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: NoNo
 * @Description: 例外的只读情况 Snapshot，类似于 clone
 * @Date: Create in 22:20 2019/1/17
 */
public class SnapshotDemo {

    private static class Data {

        private List<String> value;

        // 把内部的状态暴露到外部(外部可以修改)
        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }

    private static class SnapshotData {

        private List<String> value;

        // 浅拷贝
        public List<String> getValue() {
            return new ArrayList<>(value);
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
