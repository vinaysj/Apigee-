package apigee.delete.undeployedrevision;

import java.util.ArrayList;
import java.util.Set;

import javax.ws.rs.client.Client;

public class RevisionDeletionController {
	public static void main(String[] args) throws Exception {

		String userName;
		String password;
		String domainName;
		String orgName;
		String env;

		userName = args[0];
		password = args[1];
		domainName = args[2];
		orgName = args[3];
		env = args[4];

		// Authentication
		Client client = Connection.authenticate(userName, password);

		// calling getting the list of proxy for a particular environment
		System.out.println("Retrieving the all the api proxy for environment: " + env);

		ArrayList<String> proxyList = ProxyList.getProxyList(client, domainName, orgName, env);
		System.out.println("\nAction taken on each proxy in this environment... ");
		for (String proxyName : proxyList) {
			System.out.println("\nChecking proxy: " + proxyName);

			// List all revisions for an API proxy
			String[] allRevisions = AllRevisions.listOfAllRevisions(client, domainName, orgName, proxyName);

			// check if there are any revisions in the proxy
			if (allRevisions.length > 0) {
				// list of details on all deployments of the API proxy for all environments
				ArrayList<String> deployedRevisions = DeployedRevisions.deployedRevision(client, domainName, orgName,
						proxyName);

				// retaining few of the revisions
				Set<String> retainRevisionSet = RetainRevisions.retainRevisionList(deployedRevisions);

				// list of all the revisions which are not deployed
				ArrayList<String> revDeletionList = RevisionDeletionList.intersection(allRevisions, retainRevisionSet);

				// check whether there are undeployed revision and then delete
				if (revDeletionList.size() == 0) {
					System.out.println("No revisions deleted");
				} else {
					// Deleting the revisions - passing the undeployed revisions for deletion
					DeleteRevisions.deleteRevisions(revDeletionList, client, domainName, orgName, proxyName);
					System.out.printf("Deleted revisions:");
					for (String obj : revDeletionList) {
						System.out.printf("\t" + obj);
					}
					System.out.print("\n");
				}
			} else {
				System.out.println("There are no revisions in this proxy");
			}
		}

	}

}
