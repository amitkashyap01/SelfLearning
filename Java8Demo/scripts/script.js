var feed = 'http://services.explorecalifornia.org/json/tours.php';
var url = new java.net.URL(feed);
var input = new java.util.Scanner(url.openStream());
input.useDelimiter('#');
var contents = input.next();
contents