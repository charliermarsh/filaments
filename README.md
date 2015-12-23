# filaments

An experimental 'dumb view' architecture for Android.

## Principles

Filaments revolves around the use of dumb custom views, modelled as components. Each of these custom views is required to implement a `render` method that takes a single parameter--its view data. This view data is required to implement value semantics; the view will only be re-rendered when its data has changed. As such, Filaments requires that you build dumb, state-less views with idempotent `render` functions.

(The ideas here are similar to those used by React with the virtual DOM; however, Filament's views must be even dumber, since we're differing based on props alone, rather than the output view hierarchy.)

In more detail: with Filaments, you create custom views that extends the `Component` class; each view is parameterized on some data class that implements `ComponentData`. The contract is such that any class that implements the `ComponentData` interface must have value semantics. (In practice, this would typically be achieved with `AutoValue`.)

In the example provided here, each `Component` is intended to be linked to a custom XML layout file, with the root custom view acting as a shell (or, more specifically, a `FrameLayout`). So, for each component, you have:

1. A custom XML layout file.
2. A custom model that is used for rendering.

The the `Component` class is merely responsible for wiring its `render` data into the views in its XML file.

## Caveats

Filaments is just a toy. I wouldn't recommend using any of this code in production.

## TODOs

1. Figure out a presenter pattern--maybe draw from some of the ideas in [Flow and Mortar](https://corner.squareup.com/2014/01/mortar-and-flow.html)?
2. Find a means of enforcing the value semantics-`ComponentData` contract. (Right now, `ComponentData` is just an empty interface, and the expectation is that the programmer will only `implement` that interface on classes that have value semantics.)

## License

MIT.
