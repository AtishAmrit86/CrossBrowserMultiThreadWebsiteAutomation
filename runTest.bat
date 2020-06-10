mvn clean install -P runner -Dwebdriver.base.url=https://demo.midtrans.com -Dmetafilter="+smoke"

mvn -P runner serenity:aggregate
