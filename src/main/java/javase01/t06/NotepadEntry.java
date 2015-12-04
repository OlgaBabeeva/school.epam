package javase01.t06;

/**
 * NotepadEntry for Notepad.
 * Contains string. NotepadEntries are equal if they contain equal strings.
 */
public class NotepadEntry {

    private String content;

    public NotepadEntry(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        NotepadEntry that = (NotepadEntry) obj;

        return that.content.equals(this.content);

    }
}
