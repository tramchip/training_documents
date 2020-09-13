Readme

# This is the repo contains training materials forDP-100 for my study group 

1. Slides 
- https://docs.google.com/presentation/d/1tZ3YAHE6KAiB4JfQYApFW9-ZBL3WqgK1bkSjd6OtwJE/edit?usp=sharing
2. Records https://www.youtube.com/playlist?list=PLBIstIrTTexVulC2uKN6q1VYesR18nBPS
3. Blog posts
- Khalid's post - https://www.linkedin.com/pulse/microsoft-azure-data-scientist-exam-dp-100-khalid-waleed/?trackingId=Xr42VxxDQ5eIKtCFQKQC9w%3D%3D
- my post https://janebraine.tech/tag/dp-100/
- mock questions https://www.examtopics.com/exams/microsoft/dp-100/ - make sure to check on the comment to ensure the answer is correct 
-----------------------------------------------------------------
## Area of focus 
A large part of the exam will be on Azure SDK 
### Data Science general knowledge 
- Basic statistics and data visualization
- Normalization ( data preparation )
- **Evaluation metrics , what each metrics signal - what is the best metric for certain usecase 
- Cross validation
- ** Hyper parameter tuning (hyperdrive) **
- ** Different sampling method ( parameter for hyperdrive **
- What metric to use for unbalance dataset. 
- Feature selections ( which method for which case )
- Requires business understanding of 3 mains algorithms , anomaly detection, recommendation, utilize different data sources depends on business use case 
### Azure services 
- Apply business scenarios
- 1 question on databricks , virtual machine 
- ***Make sure to do the labs in class twice, and the github lab (1A, 1B ,2A, 2B) and make sure to understand the labs - really practice on this and understand the syntax and functions. E.g if there is an endpoint for an object then what functions the object could have . Do the lab and takes your own note
*** super emphasized on how to use datastore, and dataset in estimators, pipelines
- **Focus on Azure SDK python** - a large content of the exam will be testing on this
- ML Designer pipelines ( training and ingest pipeline ) - a few , could be questions such as gave u a training pipeline, and give u the inference pipeline for the model, and ask u which 3 modules must be modify for the given requirement.
- AutoML : automl for forecasting , decision making  ml designer in azure ML workspace , -  parameter to use to automate impute missing values, and encode categorical features- very important 
- Train model using estimator -e.g Pytorch ( estimator )
- use of param for data folder, pass in data as param / input
- *Code* get resources in Azure infrastructure here
- *Code* Loading, attaching, download, mounting, import data from *datastore*,*dataset* , deploy models and pipeline, consume pipeline, method of deployment from a script here, method of predicting
- Focus on lesson #6 Udacity Azure 
- (AKS, SDK- enviroments,when to use, benefits ) : https://docs.microsoft.com/en-us/learn/modules/use-automated-machine-learning/deploy-model
- How to invoke API for batch inference API ( 3 parameters ) , real-time inference / steaming API 
- Metadata - importing share explainner- a few 
- Small sections on contrainst of Microsoft infrastructure in the infrastructures 
- sequence type of question questions - example what are the steps to perform data science flow ( split data into sampling, random number, train data) -  need to know parallel run step in pipeline steps [[[[step1a, step1b],step2a],step2b],step3] -> is this correct 
- Scenario and choose best options
- streaming hyper paramters
- Best process to parse arguement, mountdatastore in your dataset 
- SDK syntax for autoMl 
- Roles and granting controls : data science vs it admins
- deploying containers and moving containers with pytorch
- troubleshooting AKS
- DP-100 lab 4 : how to create a compute
- how to write logs and read log results - example ways to monitor the progress of the pipeline execution
- how to troubleshoot deployed model, esp as localwebservice.
- Datadrift, maybe for deployed inferenced model, and know about alertconfigurations
- Hyperdriveconfig, must know how to interpret choice, uniform, and normal. The detail data return is not found in the learning material, so need to learn from the documentations. For example, is important to know how to interpret the output of eg uniform(01, 0.5). Is it returned as a range or only either of 2 values?
- type of policy for hyperdrive, and the type of search.
- Hyperdrive to optimize hyperparameter for classification model e.g to define primary metric goal to accuracy, maximize
- Code :  method to download model explainers to notebook
- Fairlearn ??? May be will be added 
- script pipe vs estimator pipe PythonScriptStep: Runs a specified Python script., EstimatorStep: Runs an estimator., DataTransferStep: Uses Azure Data Factory to copy data between data stores.-> how to use GPU for it 
- Most efficient to get data from the dataset -> blog storage from datastore
- AutoML : how to get the best model
- Compute targets - which one for deep learning 
*** there are questions you can not go back and review . make sure to read these well **
*** Be aware of the mock questions available online, a lot of the answers are not right **
** ultilize whiteboard , check on the review questions and move on to a next question, no copy paste **




