[![Build Status](https://travis-ci.org/evanova/eve-api-java.svg?branch=master)](https://travis-ci.org/evanova/eve-api-java)

# Eve Online API implementation in Java

Model objects and parsers for the [XML](http://ned.karbowiak.dk/API), [Eve Central](https://eve-central.com/home/develop.html) and [ZKillboard](https://github.com/EVE-KILL/zKillboard) endpoints.

For a [CREST](https://developers.eveonline.com/resource/crest) implementation, see [eve-crest-java on GitHub](https://github.com/evanova/eve-crest-java)

For DOTLAN support, see [eve-dotlan-java on GitHub](https://github.com/evanova/eve-dotlan-java)

This code is used in [Evanova for Android](https://market.android.com/details?id=com.tlabs.android.evanova).

## Quick Start
* Run `gradlew build install -x test`
* Insert as a dependency: `compile 'com.tlabs.eve:eve-api:+'`

##Usage
The simplest way of getting Eve data is by using the `DefaultEveNetwork` class.
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

### AUthentication using API keys or CREST refresh token

For requests that implement `EveAPIRequest.Authenticated`, you will need to provide API keys as parameters in the request.
This is usually done like so:

```
  request.putParam("keyID", "APIKEY");
  request.putParam("vCode", "VCODE");
```

As of Citadel, you can also use a CREST token that you have previously obtained through CREST SSO:

```
  request.putParam("accessToken", "CREST TOKEN");
  request.putParam("accessType", "character"); //'corporation' or 'character'
```

## Design

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


## Authors

evanova.mobile@gmail.com (in-game: Evanova Android)


## Contributors

You!
