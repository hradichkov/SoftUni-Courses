package P09DesignPatternsExercises.commandPattern;

public class Main {
    public static void main(String[] args) {

        TVRemote tvRemote = new TVRemote(15, "BTV");
        VolumeDownCommand volumeDown = new VolumeDownCommand(tvRemote);
        VolumeUpCommand volumeUp = new VolumeUpCommand(tvRemote);

        volumeDown.execute();
        volumeDown.execute();
        volumeUp.execute();
    }
}
