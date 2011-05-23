Requirements
------------

 * Glassfish 3.1
 * A database. I use Postgres.
 
Setup
-----

 * Create a database schema called ``hr-ryan``.
 * Install the appropriate SQL Driver into GLASSFISH_HOME/glassfish/domains/domain1/lib
   (In my case it's the [Postgres JDBC4 driver](http://jdbc.postgresql.org/download.html))
 * Create the connection pool for ``hr-ryan`` in the glassfish domain control panel.
 
