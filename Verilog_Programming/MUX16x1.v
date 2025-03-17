module MUX16x1 (
    input wire [3:0]select,
    input wire [15:0] in,
    output reg y
);

    always @(select or in) begin
        case (select)
            4'b0000: y = in[0];
            4'b0001: y = in[1];
            4'b0010: y = in[2];
            4'b0011: y = in[3];
            4'b0100: y = in[4];
            4'b0101: y = in[5];
            4'b0110: y = in[6];
            4'b0111: y = in[7];
            4'b1000: y = in[8];
            4'b1001: y = in[9];
            4'b1010: y = in[10];
            4'b1011: y = in[11];
            4'b1100: y = in[12];
            4'b1101: y = in[13];
            4'b1110: y = in[14];
            4'b1111: y = in[15];
            default: y = 0;
        endcase
    end
    
endmodule


module TB; 
    
    reg [3:0]sel;
    reg [15:0]in;
    wire op;

    MUX16x1 uut(.select(sel),.in(in),.y(op));    

    initial begin
        in = 16'b0001011101010111;
        sel = 4'b0000;#10;
        sel = 4'b0001;#10;
        sel = 4'b0010;#10;
        sel = 4'b0011;#10;
        sel = 4'b0100;#10;
        sel = 4'b0101;#10;
        sel = 4'b0110;#10;
        sel = 4'b0111;#10;
        sel = 4'b1000;#10;
        sel = 4'b1001;#10;
        sel = 4'b1010;#10;
        sel = 4'b1011;#10;
        sel = 4'b1100;#10;
        sel = 4'b1101;#10;
        sel = 4'b1110;#10;
        sel = 4'b1111;#10;
    end

    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,TB);
    end

    initial begin
        $display("Input signal : %b",in);
        $monitor("Select = %b |  Output = %b",sel,op);
    end


endmodule

