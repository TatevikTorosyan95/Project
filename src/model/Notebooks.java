package model;

public class Notebooks extends Computers{
    private float screenSize;
    private boolean isBuiltInMicrophone;

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isBuiltInMicrophone() {
        return isBuiltInMicrophone;
    }

    public void setBuiltInMicrophone(boolean builtInMicrophone) {
        isBuiltInMicrophone = builtInMicrophone;
    }

    public void info(){
        super.info();
        System.out.println("Screen Size: " + screenSize);
        System.out.println("Built In Microphone: " + (isBuiltInMicrophone ? "Yes" : "No"));
    }
}
