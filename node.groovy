node {
    // Checkout the repository from GitHub
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'YOUR_CREDENTIALS_ID', url: 'https://github.com/YOUR_REPO.git']]])

    // Use curl to send the contents of the file to a Telegram bot
    def botToken = "5392765795:AAGCvfJBRHX_N6eSIyDz0MEOZXnZgkVaaoQ"
    def chatId = "-625394738"
    sh "curl -F data=@/home/test.txt https://api.telegram.org/bot${botToken}/sendMessage -d chat_id=${chatId} -d text="$(cat /home/test.txt)'"
}
