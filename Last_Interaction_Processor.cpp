#include <iostream>
using namespace std;

class FinalConversationHandler {
public:
void processConversation() {
    string friendship = "ended";
    bool peace = true;
    bool misunderstood = true;
    bool ignored = true;

    cout << "This is probably my last text to you." << endl;

    if (misunderstood) {
        cout << "What you understood was never my intention." << endl;
    }

    if (ignored) {
        cout << "You ignored me, so I removed it." << endl;
    }

    cout << "People ki importance ivvadam kuda thappu anipinchindi ippudu." << endl;

    if (peace) {
        cout << "Better peace for both of us, so let’s just stay away." << endl;
    }

    int explanations = 100; // respect me on myself

    while (explanations--) {
        cout << "I kept explaining myself" << endl;
    }

    cout << "Honestly, I feel like I’m becoming cheap by repeatedly explaining myself." << endl;
    cout << "I’ve never spoken about you to anyone the way you spoke about me." << endl;

    string yourGoal = "Software Job";
    string myGoal = "Something beyond what we study in B.E.";

    cout << "For you, getting a " << yourGoal << " is the goal." << endl;
    cout << "For me, my aim is " << myGoal << "." << endl;

    bool focusOnAcademics = false;

    if (!focusOnAcademics) {
        cout << "I’m not even able to focus on academics properly." << endl;
    }

    cout << "I saw your LeetCode profile, LeetSync automation extension, and contests too." << endl;

    cout << "When you’re actually good at LC, I don’t understand why you said you don’t know DSA." << endl;

    cout << "Anyway, I wish you all the best for your placements and future endeavors." << endl;

    bool requestAccepted = false; // my snap request wasnt accepted
    bool instagramText = true;

    if (!requestAccepted && instagramText) {
        cout << "That Instagram text came and everything changed after that." << endl;
    }

    cout << "God has given me only one chance to prove myself." << endl;
    cout << "And I have to do it on my own." << endl;

    cout << "For the path I want to take, referrals and recommendations don’t work." << endl;
    cout << "Goodbye. The word "fool" no longer exists for me." << endl;

}

};

int main() {
  
FinalConversationHandler obj;
obj.processConversation();

return 0;

}
