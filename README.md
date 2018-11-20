Execution steps

Create a text file with the list of environment. The environments specified here would be considered for excluding the proxies which are deployed in these environments. (Text file format: each line should correspond to one environment name. File should only contain environment names)

Download the jar

Open command line prompt

Traverse to the location

Run below command with correct argument

          $java -jar RevisionDeletion_org_ex.jar userLoginID password https domain orgname filepath

Description for the arguments being passed in above command

    Username and password are the authentication details which are required for login into apigee
    Protocol would be https or http
    Domain name would be api.enterprise.apigee.com for saas and devapgw807.unix.gsm1900.org for on prem
    Organization name would be the name of organization
    Filepath is the path of the file which contains the list of environments for which the proxies deployed in this environment revision deletion will not be done.
