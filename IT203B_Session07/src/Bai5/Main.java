package Bai5;

import java.util.*;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int orderCounter = 1;

    public static void main(String[] args) {
        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();
        OrderService service = new OrderService(repo, notify);

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("6. Thêm phương thức thanh toán mới (mô phỏng)");
            System.out.println("7. Thêm chiến lược giảm giá mới (mô phỏng)");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    addCustomer();
                    break;

                case 3:
                    createOrder(service);
                    break;

                case 4:
                    service.listOrders();
                    break;

                case 5:
                    System.out.println("Doanh thu: " + service.calculateRevenue());
                    break;

                case 6:
                    System.out.println("Đã thêm phương thức thanh toán ZaloPay (mô phỏng)");
                    break;

                case 7:
                    System.out.println("Đã thêm chiến lược giảm giá VIP (mô phỏng)");
                    break;

                case 8:
                    System.out.println("Thoát chương trình");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }

    private static void addProduct() {
        System.out.print("Mã: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Danh mục: ");
        String cat = sc.nextLine();
        products.add(new Product(id, name, price, cat));
        System.out.println("Đã thêm sản phẩm " + id);
    }

    private static void addCustomer() {
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("SĐT: ");
        String phone = sc.nextLine();
        customers.add(new Customer(name, email, phone));
        System.out.println("Đã thêm khách hàng " + name);
    }

    private static void createOrder(OrderService service) {
        if (customers.isEmpty() || products.isEmpty()) {
            System.out.println("Cần có ít nhất 1 khách hàng và 1 sản phẩm!");
            return;
        }

        // In danh sách khách hàng
        System.out.println("Danh sách khách hàng:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + ". " + customers.get(i).getName());
        }
        System.out.print("Chọn khách hàng (nhập số): ");
        int cIndex = Integer.parseInt(sc.nextLine());
        Customer customer = customers.get(cIndex);

        Order order = new Order("ORD" + orderCounter++, customer);

        // In danh sách sản phẩm
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ". " + products.get(i).getName() + " - " + products.get(i).getPrice());
        }
        System.out.print("Chọn sản phẩm (nhập số): ");
        int pIndex = Integer.parseInt(sc.nextLine());
        Product product = products.get(pIndex);

        System.out.print("Số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());
        order.addItem(new OrderItem(product, qty));

        // Giảm giá
        DiscountStrategy discount;
        System.out.println("Chọn giảm giá: 1. 10%  2. 50k  3. Holiday 15%  4. Không giảm");
        int dChoice = Integer.parseInt(sc.nextLine());
        switch (dChoice) {
            case 1:
                discount = new PercentageDiscount(10);
                break;

            case 2:
                discount = new FixedDiscount(50000);
                break;

            case 3:
                discount = new HolidayDiscount(15);
                break;

            default:
                discount = new NoDiscount();
                break;
        }

        // Thanh toán
        PaymentMethod payment;
        System.out.println("Chọn thanh toán: 1. COD  2. Thẻ tín dụng  3. MoMo  4. VNPay");
        int payChoice = Integer.parseInt(sc.nextLine());
        switch (payChoice) {
            case 1:
                payment = new CODPayment();
                break;

            case 2:
                payment = new CreditCardPayment();
                break;

            case 3:
                payment = new MomoPayment();
                break;

            case 4:
                payment = new VNPayPayment();
                break;

            default:
                payment = new CODPayment();
                break;
        }

        service.createOrder(order, discount, payment);
        InvoiceGenerator.printInvoice(order);
    }
}
