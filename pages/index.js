import Head from 'next/head'
import Header from '@components/Header'
import Footer from '@components/Footer'

export default function Home() {
  return (
    <div className="container">
      <Head>
        <title>FPHunter</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main>
        <Header title="Cazadores de Formación Profesional" />
        <p className="description">
          Bienvenido a FPHunter!
        </p>
        <p>Nuestro proyecto es ayudarte!</p>
      </main>

      <Footer />
    </div>
  )
}
