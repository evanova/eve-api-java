Java Objects for Eve Online
=======
Model objects and parsers for the [XML](http://wiki.eve-id.net/APIv2_Page_Index), [CREST](https://developers.eveonline.com/resource/crest), [Eve Central](https://eve-central.com/home/develop.html) and [ZKillboard](https://github.com/EVE-KILL/zKillboard) endpoints.

This code is used in [Evanova for Android](https://market.android.com/details?id=com.tlabs.android.evanova).

Usage
=======
The simplest way of getting Eve data is by using the ```DefaultEveNetwork``` class.
```
//Have a simple HTTP/HTTPS support
final EveNetwork eve = new DefaultEveNetwork();  

//Create the request to submit
final ServerStatusRequest request = new ServerStatusRequest();

//Submit the request and receive a response
final ServerStatusResponse status = eve.execute(request); 

//Do something
System.out.println(status.getOnlinePlayers() + " pilots online");
```

If you'd rather obtain a response from an InputStream (for mocking, caching, or you have your own network code), you can use the ```EveFacade``` utility class instead:

```
//Create the request to submit
final ServerStatusRequest request = new ServerStatusRequest();

//The result of the request as a stream
InputStream in = ...

//Obtain a parsed version of the response stream
final ServerStatusResponse status = EveFacade.parse(request, in); 
```

Design
=======
Each request to an endpoint is modeled as an ```EveRequest``` associated with an ```EveResponse```:

```
public abstract class EveRequest<T extends EveResponse>
```

Each ```EveResponse``` has a corresponding ```EveParser``` which creates response instances given an InputStream:
```
public interface EveParser<T extends EveResponse> {
    T parse(InputStream in) throws IOException;
}
```

The ```EveNetwork``` interface provides an ```EveResponse``` from an ```EveRequest```
```
public interface EveNetwork {
    <T extends EveResponse> T execute(final EveRequest<T> request);
}
```
The ```DefaultEveNetwork``` class is a simple implementation using HttpUrlConnection, with support for HTTPS.


Authors
=======
evanova.mobile@gmail.com (in-game: Evanova Android)


Contributors
============
You!