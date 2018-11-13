package apigee.delete.undeployedrevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RetainRevisions {
	public static Set<String> retainRevisionList(ArrayList<String> deployedRevisions) {
		Set<String> set = new HashSet<String>();
		for (String obj : deployedRevisions) {

			int i = Integer.parseInt(obj);
			if (i >= 2) {
				String j = Integer.toString(i - 1);

				set.add(j);
			}
			set.add(obj);
		}

		return set;
	}

}
