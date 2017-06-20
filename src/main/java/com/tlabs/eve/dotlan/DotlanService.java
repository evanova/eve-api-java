package com.tlabs.eve.dotlan;

import com.tlabs.eve.dotlan.model.DotlanJumpOptions;
import com.tlabs.eve.dotlan.model.DotlanOptions;
import com.tlabs.eve.dotlan.model.DotlanRoute;

@Deprecated //use ESI
public interface DotlanService {


    DotlanRoute getHighSecRoute(final DotlanOptions options);

    DotlanRoute getLowSecRoute(final DotlanOptions options);

    DotlanRoute getFastestRoute(final DotlanOptions options);

    DotlanRoute getJumpRoute(final DotlanJumpOptions options);
}
