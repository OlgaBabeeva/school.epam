package javase01.t06;


/**
 * Notepad containing NotepadEntries.
 * Has methods for adding, removing, editing entries and showing all of them.
 * This class uses resizing array which doubles its length when there is no more space left
 * and halves it when it is quarter full.
 * Entries are not kept in order of addition.
 * When it attempts to find particular entry (for removal or editing), it searches through all entries.
 * If the entry is not found nothing happens. If there are two equal entries first one found will be
 * removed or edited.
 */
public class Notepad {

    private static final int ENTRY_NOT_FOUND = -1;

    private int numberOfEntries;
    private NotepadEntry[] entries;

    public Notepad() {
        this.entries = new NotepadEntry[2];
        this.numberOfEntries = 0;
    }

    /**
     * Adds specified entry in Notepad.
     *
     * @param newEntry entry to add
     */
    public void addEntry(NotepadEntry newEntry) {
        if (numberOfEntries == entries.length) {
            resizeTo(2 * entries.length);
        }
        entries[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    /**
     * Removes specified entry from Notepad.
     *
     * @param entry entry to add
     */

    public void removeEntry(NotepadEntry entry) {

        int index = findEntry(entry);
        if (index != ENTRY_NOT_FOUND) {
            entries[index] = entries[numberOfEntries - 1];
            entries[numberOfEntries - 1] = null;
            numberOfEntries--;
            if (numberOfEntries > 0 && numberOfEntries == entries.length / 4) {
                resizeTo(entries.length / 2);
            }
        }
    }


    /**
     * Changes specified entry in Notepad.
     *
     * @param oldEntry    entry to be changed
     * @param editedEntry new version of the entry
     */
    public void editEntry(NotepadEntry oldEntry, NotepadEntry editedEntry) {
        int index = findEntry(oldEntry);
        if (index != ENTRY_NOT_FOUND) {
            entries[index] = editedEntry;
        }
    }

    /**
     * Shows all entries in Notepad.
     */
    public void showAllEntries() {
        System.out.println();
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println(entries[i]);
        }
        System.out.println();
    }

    private int findEntry(NotepadEntry entry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (entries[i].equals(entry)) {
                return i;
            }
        }
        System.out.println("There is no entry");
        System.out.println(entry);
        System.out.println("in notepad");
        return ENTRY_NOT_FOUND;
    }

    private void resizeTo(int capacity) {

        NotepadEntry[] temp = new NotepadEntry[capacity];
        for (int i = 0; i < entries.length; i++) {
            temp[i] = entries[i];
        }
        entries = temp;
    }


}

