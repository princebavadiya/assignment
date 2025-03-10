// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class linkli {
   private int size = 0;
   linkli$node head;

   linkli() {
   }

   public void addfirst(String var1) {
      linkli$node var2 = new linkli$node(this, var1);
      if (this.head == null) {
         this.head = var2;
      } else {
         var2.next = this.head;
         this.head = var2;
      }
   }

   public void addlast(String var1) {
      linkli$node var2 = new linkli$node(this, var1);
      if (this.head == null) {
         this.head = var2;
      } else {
         linkli$node var3;
         for(var3 = this.head; var3.next != null; var3 = var3.next) {
         }

         var3.next = var2;
      }
   }

   public void print() {
      for(linkli$node var1 = this.head; var1 != null; var1 = var1.next) {
         System.out.print(var1.data + " -> ");
      }

      System.out.println("NULL");
   }

   public void deletefirst() {
      if (this.head == null) {
         System.out.println("EMPTY");
      } else {
         this.head = this.head.next;
         --this.size;
      }
   }

   public void deletelast() {
      if (this.head == null) {
         System.out.println("EMPTY!");
      } else {
         --this.size;
         if (this.head.next == null) {
            this.head = null;
         } else {
            linkli$node var1 = this.head;

            for(linkli$node var2 = this.head.next; var2.next != null; var1 = var1.next) {
               var2 = var2.next;
            }

            var1.next = null;
         }
      }
   }

   public int getsize() {
      return this.size;
   }

   public static void main(String[] var0) {
      linkli var1 = new linkli();
      Scanner var2 = new Scanner(System.in);

      while(true) {
         while(true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Print List");
            System.out.println("6. Get Size");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int var3 = var2.nextInt();
            var2.nextLine();
            switch (var3) {
               case 1:
                  System.out.print("Enter data: ");
                  String var4 = var2.nextLine();
                  var1.addfirst(var4);
                  break;
               case 2:
                  System.out.print("Enter data: ");
                  String var5 = var2.nextLine();
                  var1.addlast(var5);
                  break;
               case 3:
                  var1.deletefirst();
                  break;
               case 4:
                  var1.deletelast();
                  break;
               case 5:
                  var1.print();
                  break;
               case 6:
                  System.out.println("Size of list: " + var1.getsize());
                  break;
               case 7:
                  System.out.println("Exiting...");
                  var2.close();
                  System.exit(0);
               default:
                  System.out.println("Invalid choice. Try again.");
            }
         }
      }
   }
}

