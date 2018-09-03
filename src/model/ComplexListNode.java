package model;

public class ComplexListNode {
    public int value;
    public ComplexListNode next;
    public ComplexListNode sibling;

    public ComplexListNode() {
    }

    public ComplexListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ComplexListNode cur = this;
        while(cur!=null) {
            ret.append(cur.value);
            if(cur.sibling!=null)
                ret.append("("+cur.sibling.value+")");
            else{
                ret.append("(_)");
            }
            ret.append('\t');
            cur = cur.next;
        }
        return ret.toString();
    }
}
