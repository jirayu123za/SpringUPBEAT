package RestAPI;
import com.project.upbeat.GameProcess.Game;
import com.project.upbeat.Exception.*;
import com.project.upbeat.Game.*;
import com.project.upbeat.Management.*;
import com.project.upbeat.Request.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RESTAPI")
public class GameAPI{

    @PatchMapping
    public ResponseEntity<Game> gameAPI(@RequestBody GameRequest request){
        try{
            if(request.getNameOfPlayer1() == null || request.getNameOfPlayer2() == null){
                throw new WrongRequest("We should have name of Player!!");
            }else{
                String configuration = configChangeToString(request.getConfig());
                Game thisGame = BuildGame.getBuildGame(request.getNameOfPlayer1(), request.getNameOfPlayer2(), request.getConfig());
                ManageConstructionPlan.setGame(thisGame);
                return ResponseEntity.ok(thisGame);
            }

        }catch(Exception exception){
            throw new WrongRequest(exception.getMessage());
        }
    }

    private String configChangeToString(ConfigurationRequest config){
        String configuration = "";
        configuration += "rows = " + config.getRows() + "\n";
        configuration += "cols = " + config.getCols() + "\n";
        configuration += "init_plan_min = " + config.getInit_plan_min() + "\n";
        configuration += "init_plan_sec = " + config.getInit_plan_sec() + "\n";
        configuration += "init_budget = " + config.getInit_budget() + "\n";
        configuration += "init_center_dep = " + config.getInit_center_dep() + "\n";
        configuration += "plan_rev_min = " + config.getPlan_rev_min() + "\n";
        configuration += "plan_rev_sec = " + config.getPlan_rev_sec() + "\n";
        configuration += "rev_cost = " + config.getRev_cost() + "\n";
        configuration += "max_dep = " + config.getMax_dep() + "\n";
        configuration += "interest_pct = " + config.getInterest_pct() + "\n";
        return configuration;
    }
}