class node():
    val = 0;
    next_top = None;
    next_bottom = None;

    def setVal(self, val):
        self.val = val

    def getVal(self):
        return self.val

    def linkTop(self, top):
        self.next_top = top

    def linkBottom(self, bottom):
        self.next_bottom = bottom

    def getNextTop(self):
        return self.next_top

    def getNextBotoom(self):
        return self.setVal()


def push(val):
    pass