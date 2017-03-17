package com.thoughtworks;

import com.reagroup.pact.provider.PactFile;
import com.reagroup.pact.provider.PactRunner;
import com.reagroup.pact.provider.ProviderState;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.when;

@RunWith(PactRunner.class)
@ContextConfiguration(classes = MockConfiguration.class)
@PactFile("file:src/test/resources/seed_consumer-seed_provider.json")
public class PactContractTests {

    @Autowired
    private SeedController seedController;

    @Autowired
    private SeedRepository seedRepository;

    @ProviderState("there are no seeds")
    public SeedController whenThereAreNoSeeds() {
        when(seedRepository.hasSeeds()).thenReturn(false);
        return seedController;
    }

    @ProviderState("there are seeds")
    public SeedController whenThereAreSeeds() {
        when(seedRepository.hasSeeds()).thenReturn(true);
        return seedController;
    }

}
