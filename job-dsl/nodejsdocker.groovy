job('NodeJS Docker app') {
   scm {
     git('git://github.com/BoxlittleDesignAgency/simpleweb.git') { node ->
        node / gitConfigName('Demola')
        node / gitConfigEmail('jenkins@boxlittle.com')
     }
   }
   triggers {
     scm('H/5 * * * *')
   }
   wrappers {
     nodejs('nodejs') // this is the name of the NodeJS installation in
                      // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
   }
   steps {
     dockerBuildAndPublish {
       repositoryName('BoxlittleDesignAgency/docker-nodejs-demo')
       tag('${GIT_REVISION,length=9}')
       registryCredentials('dockerhub')
       forcePull(false)
       forceTag(false)
       createFingerprints(false)
       skipDecorate()
     }
   }
}
