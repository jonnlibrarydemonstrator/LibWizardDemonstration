package navillebrasil.com.libwizarddemonstration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.master.killercode.wizard.GetWizardStatus;
import com.master.killercode.wizard.Splash.SplashActivity;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<WizardPageModel> wList = new ArrayList<>(); // create array for Page Wizard

    private String SPLASH_INIT = "splash_init";
    private String WIZARD_INIT = "wizard_init";
    private String SPLASH_WIZARD_INIT = "splash_wizard_init";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
        initActions();
        initStrings();

    }

    private void initVars() {

        // init e create Pages for Wizard
        WizardPageModel page1 = new WizardPageModel("Hello");
        wList.add(page1); // add page in arrayPages for Wizard

        WizardPageModel page2 = new WizardPageModel("Wow", "This is page two");
        wList.add(page2);

        WizardPageModel page3 = new WizardPageModel("Humm", "This is page Tree", R.mipmap.ic_launcher);
        wList.add(page3);

        WizardPageModel page4 = new WizardPageModel("Ops", "This is page Four", WizardPageModel.NO_DRAWABLE, getResources().getColor(R.color.Color_Palet_Flat_ALIZARIN));
        wList.add(page4);

        WizardPageModel page5 = new WizardPageModel("Finish", "This is page Five", R.mipmap.ic_launcher, getResources().getColor(R.color.Color_Palet_Flat_EMERALD), getResources().getColor(R.color.app_blue));
        wList.add(page5);
    }

    private void initActions() {
        Button wizard = findViewById(R.id.wizard);

        wizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WizardActivity wizard = new WizardActivity(MainActivity.this, wList); // init WizardActivity with Activity and ArrayPages
//                wizard.setThemeGoogle(); // set Theme Google in Wizard
                wizard.setAfterWizard(MainActivity.class); // set Page after WizardActivity
                wizard.setWizardFinished(WIZARD_INIT); // attach Wizard's name, if create multiples WizardsActivitys
                wizard.show(); // show WizardActivity, if add true in param, activity is finished

            }
        });

        Button splash = findViewById(R.id.splash);
        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplashActivity splash = new SplashActivity(MainActivity.this); // init SplashActivity with Activity
                splash.setTimer(5); // set Time for SplashActivity Show
                splash.setColorBackground(0xFF909090); // set BackGround Color in SplashActivity
//                splash.setSplashFinished(SPLASH_INIT); // attach SplashActivity's name, if create multiples SplashActivity
                splash.setImage(R.mipmap.ic_launcher); // add image center in SplashActivity
                splash.setTextTitle("Hello!"); // add Title
                splash.show(); // create e init SplashActivity, if add true in param, activity is finished

            }
        });

        Button splashAndWizard = findViewById(R.id.splashAndWizard);
        splashAndWizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplashActivity splash = new SplashActivity(MainActivity.this, MainActivity.class); // Create Splash With Wizard, init With Activity and Activity After Wizard Activity
//                splash.setSplashFinished(SPLASH_WIZARD_INIT);
                splash.setWizard(wList); // add ArrayPage For WizardActivity
                splash.setWizardThemeGoogle(); // set Theme Google in Wizard
                splash.show(true);// create e init SplashActivity , if add true in param, activity is finished

            }
        });

        Button status = findViewById(R.id.status);
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initStrings();
            }
        });

    }

    private void initStrings() {

        GetWizardStatus wPrefs = new GetWizardStatus(MainActivity.this); // Create GetWizardStatus with Context
        Boolean splash_init = wPrefs.getStatusFinishedFrom(SPLASH_INIT); // get SPLASH_INIT is finished or not , return true is finish or false for not
        Boolean wizard_init = wPrefs.getStatusFinishedFrom(WIZARD_INIT); // iden
        Boolean splash_wizard_init = wPrefs.getStatusFinishedFrom(SPLASH_WIZARD_INIT); //iden

        Toast.makeText(this, SPLASH_INIT + ":" + splash_init + " , " + WIZARD_INIT + ":" + wizard_init + " , " + SPLASH_WIZARD_INIT + ":" + splash_wizard_init, Toast.LENGTH_LONG).show();

    }
}

