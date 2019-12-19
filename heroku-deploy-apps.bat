#heroku-deploy-apps.bat
heroku container:release web --app=g15-shop-admin-ui

heroku container:release web --app=g15-shop-ui