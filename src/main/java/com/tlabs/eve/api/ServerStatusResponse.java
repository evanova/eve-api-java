package com.tlabs.eve.api;



public final class ServerStatusResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8218485055974441769L;

    private int playersOnline = 0;
    private boolean serverOpen = false;

    public int getOnlinePlayers() {
        return playersOnline;
    }

    public void setOnlinePlayers(int playerOnline) {
        this.playersOnline = playerOnline;
    }

    public void setOnlinePlayers(String playerOnline) {
        this.playersOnline = Integer.parseInt(playerOnline);
    }

    public boolean getServerOpen() {
        return serverOpen;
    }

    public void setServerOpen(boolean serverOpen) {
        this.serverOpen = serverOpen;
    }

    public void setServerOpen(String serverOpen) {
        setServerOpen("true".equalsIgnoreCase(serverOpen));
    }

}
