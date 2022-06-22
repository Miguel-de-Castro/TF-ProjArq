# PORT 8765
cd Tarefa1_SistemaDeVendas/ApiGatewayServico
mvn clean package
docker build --rm -t gateway:latest .

cd ../..

# PORT 8200
cd Tarefa1_SistemaDeVendas/EstoqueServico
mvn clean package
docker build --rm -t estoque:latest .

cd ../..

# 8761
cd Tarefa1_SistemaDeVendas/NamingServerServico
mvn clean package
docker build --rm -t nameserver:latest .

cd ../..

# PORT 8100
# cd Tarefa1_SistemaDeVendas/VendaServico
# mvn clean package
# docker build --rm -t venda:latest .

# cd ../..

# PORT 8080
cd Tarefa1_SistemaDeVendas/SvBkEndProt
mvn clean package
docker build --rm -t prototipo:latest .

cd ../..