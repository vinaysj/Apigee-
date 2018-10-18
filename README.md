# Apigee-
Jar file to Delete undeployed revisions in an api proxy

---
	Deleting the undeployed revisiond in a api proxy; retaining one undeployed revision below the deployed revision. 
---

Overview:

- This jar can be used to delete all the undeployed revision in an environment. The undeployed revision which is below the deployed revision will be retained. Not all the undeployed revisions will be deleted. 
- The environment is used to retrieve all the proxy names 
- Irrespective of which evironment the revisions are delpoyed, this code retains the revision and one undeployed revision below it deleting the rest.  

---

Input arguments:

The arguments which needs to be passed to this jar are:

	username 
	password
	domain name
	organization name
	evironment name

---

Execution steps: 

-Download the jar
-Open command line prompt
-Traverse to the locaion
-Run this command with correct argument

	$java -jar RevisionDeletion.jar userLoginID password api.enterprise.apigee.com vinaysj17-eval test
 
Note: there is a space delimiter inbetween arguments being passed. 

---

Argument description: 

Username and password are the authentication details which are required for login into apigee

Domain name would be api.enterprise.apigee.com for saas, for on prem the domain name would be different. 

Organization name would be the name of organization 

Environment name would be the environment of the proxies deployed. 

---