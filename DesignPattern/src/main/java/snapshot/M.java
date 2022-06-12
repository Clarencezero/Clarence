package snapshot;

import java.util.Scanner;

/**
 * 每来一条记录都做一次快照。对于大内存对象而言，这是不可取的。
 * 对于这个小程序，我们使用指针记录当前文本长度，从而只保留一份文本文件。
 *
 * 低频率倒是备份，高频率增量备份
 */
public class M {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.toString());
            } else if (input.equals(":undo")) {
                Snapshot snapshot = snapshotHolder.popSnashot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotHolder.pushSnashot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
