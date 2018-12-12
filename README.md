## Introduce<br/>
Hi, I am Jay. Thanks for give me this chance to interview with you.</br>
Here's my demo and documentation, Thanks for watch this :D<br/>

## Goal<Br/>
1. Create an app which can play MP3 file via network and local storage
2. Good UI/UX
3. Making some trade-off due to time limit 

## What I achieved</br>
1. Read Mp3 File and play its audio</br>
2. Establish Architecture for further extend</br>
</br>

## What I haven't implement </br>
1. Get mp3 files from api</br>
2. Mp3 video display</br>
3. Start/Stop/Pause function<br/>
4. UI/UX
<br/>

## Trade off<br/>
Because we only have 3 hours to develop our prototype, I decide create a minimum viable product,
which only fit least requirement, but keep our product a flexible to easier implement further feature.<br/>

1. We have _**ViewModel**_, which provide us the ability to use test-driven development, easy to test and seperate the duty between view and logic 
2. Our app have _**dependency injection**_, which can decouple each component's dependency efficiently<br/>
3. Using _**LiveData**_, prevent some memory leakage due to subscrition misuse
4. Adapt _**Epoxy**_ as recycler view, which announced by airbnb. Its contain some good feature, for example, it won't re-render same item, render only changed item, improve efficiency
5. Using _**RxJava**_ to finish multi-thread behavior. Unfortunately, in our prototype, we didn't find time to show its powerful functions.
But in practical development, it's full of multi-thread task, all the heavy-loading task should execute on worker thread to ensure UI thread can provide user good user experience.
By introduce RxJava, we can easily achieve these asynchronous behavior, and don't need lots of callback

## Conclusion<br/>
Thanks for watching this documention, to be honest, it's not an easy demo for me because I have no experience in video/audio before.<br/>
Due to the time limit, I can only implement some features I think it will be the most important, and focus on build a robust, flexible architechure.<br/>
In my opinion, an excellent app must have gather everyone's efforts, so having a good architecture is my top priority.<br/>

Again, thanks for your watching. <br/>
<br/>
Jay Chen<br/>
