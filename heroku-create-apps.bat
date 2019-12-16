#heroku-create-apps.bat
#heroku apps:create g15-shop-admin-ui
heroku apps:create g15-shop-ui
heroku addons:create heroku-postgresql:hobby-dev --app g15-shop-admin-ui
heroku addons:create heroku-postgresql:hobby-dev --app g15-shop-ui
heroku config:set JDBC_DRIVER_CLASS=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app g15-shop-admin-ui
heroku config:set JDBC_DRIVER_CLASS=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app g15-shop-ui