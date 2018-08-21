# I'm Napping
An SMS auto-reply app designed for people who nap so frequently that their friends often question if they are still alive. This app will auto-reply to your friends' texts and let them know that you are still alive - just napping.

**This is still a work in progress.**

## Lessons I have learned

 - Using a new language like Kotlin instead of Java doesn't provide benefits unless you truly take time to understand the new language. I ended up writing Kotlin as I would Java code, aside from a few minor tweaks.
 
 - It is difficult to maintain MVP architecture even in small apps. I ran into context-dependent logic that I wasn't sure where to put. Logic doesn't belong in the view, but this logic also doesn't belong in the presenter since it should be free of Android SDK code. I think dependency injection is something that can help with my issue, I will explore this in the future.
