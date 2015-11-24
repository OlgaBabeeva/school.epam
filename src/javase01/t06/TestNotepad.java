package javase01.t06;


public class TestNotepad {
    public static void main(String[] args) {
        Notepad n = new Notepad();

        n.addEntry(new NotepadEntry("This is the way the world ends"));
        n.addEntry(new NotepadEntry("This is the way the world ends"));
        n.addEntry(new NotepadEntry("This is the way the world ends"));
        n.addEntry(new NotepadEntry("Not with a bang but a whimper."));

        n.showAllEntries();

        n.removeEntry(new NotepadEntry("Not with a bang but a whimper."));
        n.showAllEntries();

        n.removeEntry(new NotepadEntry("Not with a bang but a whimper."));

        n.editEntry(new NotepadEntry("This is the way the world ends"),
                new NotepadEntry("First line changed"));

        n.showAllEntries();
    }

}
