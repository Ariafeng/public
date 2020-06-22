/* loadLocalSettings.groovy
   ##################################################
   # Created by Lin Ru at 2018.10.01 22:00          #
   #                                                #
   # A Part of the Project jenkins-library          #
   #  https://github.com/Statemood/jenkins-library  #
   ##################################################
*/

def call(){
    def local_data = readFromYaml()

    try {
        if (SETTINGS) {
            if (fileExists(SETTINGS)) {
                log.i "Loading local settings"

                load(SETTINGS)
            }
            else {
                log.w "File not found: " + SETTINGS
            }
        }
        else {
             log.w "Undefined 'SETTINGS'"
        }
    }
    catch (e) {
        log.e "Error occurred during detect 'SETTINGS'"
    }

    log.i "Load defaults"
    defaults()
}

def readFromYaml() {
    private yf = 'jenkins.yaml'
    if (fileExists(yf)) {
        try {
            log.i "Read config from " + yf
            def yaml_data = readYaml file: yf

            return yaml_data
        }
        catch (e) {
            throw e
        }
    }
}

def readFromJson() {
    private jf = 'jenkins.json'
    if (fileExists(jf)) {
        try {
            log.i "Read config from " + jf
            json_data = readJSON file: jf

            return json_data
        }
        catch (e) {
            throw e
        }
    }
}

def defaults(){
    Config.data['build.command.unit.test']     = "mvn test"
}