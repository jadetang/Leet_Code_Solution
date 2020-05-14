package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.junit.Test;
import util.Assert;

public class _1146_Snapshot_Array {

    @Test
    public void test() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        Assert.assertEqual(0, snapshotArray.snap());
        snapshotArray.set(0, 6);
        Assert.assertEqual(5, snapshotArray.get(0, 0));
    }

    @Test
    public void test2() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        Assert.assertEqual(0, snapshotArray.snap());
        snapshotArray.set(0, 6);
        Assert.assertEqual(5, snapshotArray.get(0, 0));
    }

    @Test
    public void test3() {
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 15);
        Assert.assertEqual(0, snapshotArray.snap());
        Assert.assertEqual(1, snapshotArray.snap());
        Assert.assertEqual(2, snapshotArray.snap());
        Assert.assertEqual(15, snapshotArray.get(0, 2));
        Assert.assertEqual(3, snapshotArray.snap());
        Assert.assertEqual(4, snapshotArray.snap());
        Assert.assertEqual(15, snapshotArray.get(0, 0));
    }

    static class SnapshotArray {

        List<SnapData> snapList;

        private int snapId;

        public SnapshotArray(int length) {
            this.snapList = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                this.snapList.add(new SnapData());
            }
            this.snapId = 0;
        }

        public void set(int index, int val) {
            this.snapList.get(index).snapShot(this.snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return this.snapList.get(index).getData(snap_id);
        }

        public static class SnapData {

            private TreeMap<Integer, Integer> data;

            public SnapData() {
                data = new TreeMap<>();
                data.put(0, 0);
            }

            Integer getData(Integer snap) {
                return data.floorEntry(snap).getValue();
            }

            void snapShot(Integer snapshot, Integer currentValue) {
                data.put(snapshot, currentValue);
            }
        }
    }

}
