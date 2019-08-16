package io.pivotal.support.rogueinstances;

import io.pivotal.support.rogueinstances.objects.BackingApp;
import io.pivotal.support.rogueinstances.orphan.ResultsManipulation;
import io.pivotal.support.rogueinstances.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RogueinstancesApplication implements CommandLineRunner {
	static String[] ccResultsRefined = {"Hello","World","Pivotal","JSON"};
	static String[] dbResultsRefined = {"MySQL","JSON","Spring","Hello"};
	static String appNameTest = "config-ab73664f-6d18-4eba-be91-998a4caaebc4";

	@Autowired
	InstanceRepository instanceRepository;

	public static void main(String[] args) {
		SpringApplication.run(RogueinstancesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{
		BackingApp test = new BackingApp(appNameTest);

		// Checks with database for specific application GUID
		System.out.println(instanceRepository.existsByServiceInstanceId(test.getAppGUID()));


		ArrayList<String> cloudOrphans = ResultsManipulation.findOrphans(ccResultsRefined, dbResultsRefined);
		for (int i=0; i < cloudOrphans.size(); i++){
			System.out.println(cloudOrphans.get(i) + " appears to be Cloud Controller orphaned," +
					" we recommend checking manually before performing a cleanup.");
		}
		System.out.println();
		ArrayList<String> dbOrphans = ResultsManipulation.findOrphans(dbResultsRefined, ccResultsRefined);
		for (int i=0; i < dbOrphans.size(); i++){
			System.out.println(dbOrphans.get(i) + " appears to be Broker Database orphaned," +
					" we recommend checking manually before performing a cleanup.");
		}

}

}
