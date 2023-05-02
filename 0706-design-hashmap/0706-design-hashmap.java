class MyHashMap {
    private final int size = 1_000_000;
    private final LinkedList<Entry>[] buckets = new LinkedList[size];

    public void put(int key, int value) {
        final int hash = Objects.hash(key) % size;

        final LinkedList<Entry> bucket = buckets[hash];
        if (bucket != null) {
            final Entry entry = search(bucket, key);
            if (entry != null) {
                entry.value = value;
            } else {
                bucket.add(new Entry(key, value));
            }
        } else {
            final LinkedList<Entry> newBucket = new LinkedList<>();
            newBucket.add(new Entry(key, value));

            buckets[hash] = newBucket;
        }
    }

    public int get(int key) {
        final int hash = Objects.hash(key) % size;

        final LinkedList<Entry> bucket = buckets[hash];
        if (bucket != null) {
            final Entry entry = search(bucket, key);
            if (entry != null) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        final int hash = Objects.hash(key) % size;

        final LinkedList<Entry> bucket = buckets[hash];
        if (bucket != null) {
            final Entry entry = search(bucket, key);
            if (entry != null) {
                bucket.remove(entry);
            }
        }
    }

    private Entry search(LinkedList<Entry> bucket, int key) {
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry;
            }
        }
        return null;
    }

    private static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */