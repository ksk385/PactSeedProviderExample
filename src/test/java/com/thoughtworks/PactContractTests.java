package com.thoughtworks;

import com.reagroup.pact.provider.PactFile;
import com.reagroup.pact.provider.PactRunner;
import com.reagroup.pact.provider.ProviderState;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by krkrishn on 3/17/17.
 */
@RunWith(PactRunner.class)
@SpringBootTest
@PactFile("file:src/test/resources/seed_consumer-seed_provider.json")
public class PactContractTests {

    @Autowired
    private SeedController seedController;

    @ProviderState("there are no seeds")
    public SeedController whenThereAreNoSeeds() {
        return seedController;
    }
}
