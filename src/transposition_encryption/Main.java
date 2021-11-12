package transposition_encryption;

public class Main {

    public static void main(String[] args) {
        Integer[] p = {3, 2, 5, 1, 4};
        Transposition tr = new Transposition("hello",p);
        String enc = tr.encryption();
        System.out.println("encrypted string is : "+ enc);
        System.out.println("decrypted : " + tr.dechiffrement("32514",enc));

    }


}
