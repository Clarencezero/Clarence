package snapshot;

import java.util.Stack;

public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();
    public Snapshot popSnashot() {
        return snapshots.pop();
    }

    public void pushSnashot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
