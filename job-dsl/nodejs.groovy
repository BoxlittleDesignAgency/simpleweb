job('NodeJS app') {
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
     Nodejs('nodejs') // this is the name of the NodeJS installation in
                      // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
   }
   steps {
     shell("npm install")
   }
}
