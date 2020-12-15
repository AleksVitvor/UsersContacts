using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace Library.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "roles",
                columns: table => new
                {
                    ROLE_ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    ROLE_NAME = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_roles", x => x.ROLE_ID);
                });

            migrationBuilder.CreateTable(
                name: "users",
                columns: table => new
                {
                    USER_ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    USER_USERNAME = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: false),
                    USER_PASSWORD = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: false),
                    ROLE_ID = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_users", x => x.USER_ID);
                    table.ForeignKey(
                        name: "FK_users_roles_ROLE_ID",
                        column: x => x.ROLE_ID,
                        principalTable: "roles",
                        principalColumn: "ROLE_ID",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "contacts",
                columns: table => new
                {
                    CONTACT_ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    CONTACT_NAME = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: false),
                    CONTACT_SURNAME = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: true),
                    CONTACT_PHONE = table.Column<string>(type: "longtext CHARACTER SET utf8mb4", nullable: false),
                    USER_ID = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_contacts", x => x.CONTACT_ID);
                    table.ForeignKey(
                        name: "FK_contacts_users_USER_ID",
                        column: x => x.USER_ID,
                        principalTable: "users",
                        principalColumn: "USER_ID",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_contacts_USER_ID",
                table: "contacts",
                column: "USER_ID");

            migrationBuilder.CreateIndex(
                name: "IX_users_ROLE_ID",
                table: "users",
                column: "ROLE_ID");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "contacts");

            migrationBuilder.DropTable(
                name: "users");

            migrationBuilder.DropTable(
                name: "roles");
        }
    }
}
