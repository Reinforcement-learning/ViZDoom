
import enums.Button;
import enums.GameVar;
import enums.ScreenFormat;
import enums.GameMode;
import java.util.*;
import java.lang.Integer;
import java.lang.Boolean;
public class JavaExample {

public static void main (String[] args) {
	
	ViziaDoomGameJava dg= new ViziaDoomGameJava();
	System.out.println("VIZIA MAIN EXAMPLE");


    dg.setDoomGamePath("./viziazdoom");
    dg.setDoomIwadPath("../../scenarios/doom2.wad");
    dg.setDoomFilePath("../../scenarios/s1_b.wad");
    dg.setDoomMap("map01");
    dg.setEpisodeTimeout(200);
    dg.setLivingReward(-1);

    dg.setScreenResolution(640, 480);

    dg.setRenderHud(false);
    dg.setRenderCrosshair(false);
    dg.setRenderWeapon(true);
    dg.setRenderDecals(false);
    dg.setRenderParticles(false);

    dg.setVisibleWindow(true);

    dg.setDisabledConsole(true);

    dg.addAvailableButton(Button.MOVE_LEFT);
    dg.addAvailableButton(Button.MOVE_RIGHT);
    dg.addAvailableButton(Button.ATTACK);

    dg.addStateAvailableVar(GameVar.HEALTH);
    dg.addStateAvailableVar(GameVar.KILLCOUNT);


    dg.init();
    //dg->newEpisode();
    int[] action=new int[3];

    action[0] = 1;
    action[1] = 0;
    action[2] = 1;

    int iterations = 10;
    int ep=1;
    for(int i = 0;i<iterations; ++i){

        if( dg.isEpisodeFinished() ){
            dg.newEpisode();
        }
        State s = dg.getState();

        System.out.println( "STATE NUMBER: " + s.number + " HP: " + s.vars[0] + " KILLS: " + s.vars[1] );

        dg.setNextAction(action);
        dg.advanceAction(true, true, 4);

         System.out.println("reward: "+dg.getLastReward());
    }
    dg.close();
	System.out.println("KONIEC");
  }

}