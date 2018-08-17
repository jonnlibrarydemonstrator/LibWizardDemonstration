package navillebrasil.com.libwizarddemonstration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.master.killercode.wizard.Splash.SplashActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

public class Fisrt extends AppCompatActivity {
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WizardPageModel page1 = new WizardPageModel("Hello");
        wList.add(page1);

        SplashActivity splash = new SplashActivity(Fisrt.this, MainActivity.class);
        splash.setSplashFinished("initSplash");
        splash.setWizard(wList);
        splash.setWizardThemeGoogle();
        splash.show(true);

    }


}
