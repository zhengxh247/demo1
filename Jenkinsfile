pipeline {
  agent {
    node {
      label 'maven'
    }
  }

    parameters {
        string(name:'THEVERSION',defaultValue: '1.0.0',description:'')
        string(name:'git_tag',defaultValue: 'origin/master',description:'')
        string(name:'ACCESS_TOKEN_EXPIRE',defaultValue: '3600',description:'access token 过期时间,单位为秒')
        string(name:'REFRESH_TOKEN_EXPIRE',defaultValue: '43200',description:'refresh token 有效时间，单位秒 1296000-30天')
        booleanParam(name:'verifyCodeStatus',defaultValue: 'True',description:'是否显示验证码')
        choice(name: 'dbinit',choices:'never\nalways', description: '数据初始化')
    }

     environment {
        DOCKER_CREDENTIAL_ID = 'harbor-id'
        GITLAB_CREDENTIAL_ID = 'devops'
        KUBECONFIG_CREDENTIAL_ID = 'kubeconfig'
        SONAR_CREDENTIAL_ID= 'sonar-token'

        APP_PREFIX = 'maxbase'
        DBINIT = "${env.dbinit}"
        VERIFY_CODE = "${env.verifyCodeStatus}"
        THEVERSION = "${env.THEVERSION}"
        DOCKERHUB_NAMESPACE = 'maxbase'

        REGISTRY = 'reg.cluster.local:8443'
        IP_ADDRESS = '10.134.82.232'
        APP_NAME = 'bgit-maxbase-boss-admin'
        GITLAB_url= 'http://10.60.136.163:10080/maxbase/maxbase-group/maxbase-boss.git'
        NAMESPACE = 'bgit-dev-spring-component'
        CONTAINER_PORT = '10014'
        MYSQL_HOST = 'mq'
        MYSQL_PORT = '3306'
        EUREKA_HOST = 'eureka-1'
        EUREKA_PORT = '8761'
        REDIS_HOST  = 'redis-1'
        REDIS_PORT = '6379'
        MQ_HOST = 'mq'
        MQ_PORT = '5672'
        SERVICE_PORT = '30694'
    }

    stages {
        stage('代码检出') {
         steps {
          echo 'checkout strart ...'
          echo "分支tag为：${env.git_tag}"
          script {
          checkout([$class: 'GitSCM', branches: [[name: "${env.git_tag}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "$GITLAB_CREDENTIAL_ID", url: "$GITLAB_url"]]])
          // 当前工作空间授权
          sh "chmod -R 777 ${env.WORKSPACE}"
           }
          }
         }

        stage ('单元测试') {
            steps {
                container ('maven') {
                    sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -e -U  -Dmaven.test.failure.ignore=true"
                }
            }
        }

      

        stage ('打包镜像 & 上传开发harbar仓库') {
            steps {
                container ('maven') {
                    sh 'mvn -o -Dmaven.test.skip=true clean package'
					dir('scripts/bgit') {
                      sh "cp ${env.WORKSPACE}/maxbase-boss-admin/target/*.jar ."
                      sh "docker build -t $REGISTRY/$APP_PREFIX/$APP_NAME:maxbase-$BRANCH_NAME-$THEVERSION ."
                    }
                    withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,credentialsId : "$DOCKER_CREDENTIAL_ID" ,)]) {
                        sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
                        sh 'docker push  $REGISTRY/$APP_PREFIX/$APP_NAME:maxbase-$BRANCH_NAME-$THEVERSION'
                    }
                }
            }
        }

        stage('push latest'){
           when{
             branch 'master'
           }
           steps{
                container ('maven') {
                  sh 'docker tag  $REGISTRY/$APP_PREFIX/$APP_NAME:maxbase-$BRANCH_NAME-$THEVERSION  $REGISTRY/$APP_PREFIX/$APP_NAME:maxbase-$BRANCH_NAME-latest '
                  sh 'docker push  $REGISTRY/$APP_PREFIX/$APP_NAME:maxbase-$BRANCH_NAME-latest '
                }
           }
        }

        stage('发布开发环境') {
          when{
            branch 'master'
          }
          steps {
            input(id: 'deploy-to-dev', message: 'deploy to dev?')
            kubernetesDeploy(configs: "scripts/bgit/boss-statefulset.yaml", enableConfigSubstitution: true, kubeconfigId: "$KUBECONFIG_CREDENTIAL_ID")
          }
        }
	    
        stage('clean environment') {
           steps {
           echo 'clean environment strart ...'
           echo 'clean none images ...'
           script {
            def result = sh(script: "docker rmi \$(docker images | grep 'none' | awk '{print \$3}')", returnStatus: true)
            if(result == 0){
            echo '清理NONE镜像成功'
              }
            }
          }
         }
       
    }
}

