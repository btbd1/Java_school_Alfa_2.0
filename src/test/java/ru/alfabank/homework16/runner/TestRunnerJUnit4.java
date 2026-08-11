package ru.alfabank.homework16.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/homework16/features",
    glue = {"ru.alfabank.homework16.steps", "ru.alfabank.homework16.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
    tags = "@regression"
)
public class TestRunnerJUnit4 {
}
