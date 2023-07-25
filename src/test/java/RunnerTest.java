import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources",
        },
        stepNotifications = true,
        publish = true,
        plugin = { "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" }
)

public class RunnerTest {}
